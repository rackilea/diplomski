import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.Response;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ChromeExtender {
    @Nonnull
    private MyChromeDriver m_wd;

    public ChromeExtender(@Nonnull MyChromeDriver wd) {
        m_wd = wd;
    }

    public void takeScreenshot(@Nonnull File output) throws Exception {
        Object visibleSize = evaluate("({x:0,y:0,width:window.innerWidth,height:window.innerHeight})");
        Long visibleW = jsonValue(visibleSize, "result.value.width", Long.class);
        Long visibleH = jsonValue(visibleSize, "result.value.height", Long.class);

        Object contentSize = send("Page.getLayoutMetrics", new HashMap<>());
        Long cw = jsonValue(contentSize, "contentSize.width", Long.class);
        Long ch = jsonValue(contentSize, "contentSize.height", Long.class);

        /*
         * In chrome 61, delivered one day after I wrote this comment, the method forceViewport was removed.
         * I commented it out here with the if(false), and hopefully wrote a working alternative in the else 8-/
         */
        if(false) {
            send("Emulation.setVisibleSize", ImmutableMap.of("width", cw, "height", ch));
            send("Emulation.forceViewport", ImmutableMap.of("x", Long.valueOf(0), "y", Long.valueOf(0), "scale", Long.valueOf(1)));
        } else {
            send("Emulation.setDeviceMetricsOverride",
                ImmutableMap.of("width", cw, "height", ch, "deviceScaleFactor", Long.valueOf(1), "mobile", Boolean.FALSE, "fitWindow", Boolean.FALSE)
            );
            send("Emulation.setVisibleSize", ImmutableMap.of("width", cw, "height", ch));
        }

        Object value = send("Page.captureScreenshot", ImmutableMap.of("format", "png", "fromSurface", Boolean.TRUE));

        // Since chrome 61 this call has disappeared too; it does not seem to be necessary anymore with the new code.
        // send("Emulation.resetViewport", ImmutableMap.of()); 
        send("Emulation.setVisibleSize", ImmutableMap.of("x", Long.valueOf(0), "y", Long.valueOf(0), "width", visibleW, "height", visibleH));

        String image = jsonValue(value, "data", String.class);
        byte[] bytes = Base64.getDecoder().decode(image);

        try(FileOutputStream fos = new FileOutputStream(output)) {
            fos.write(bytes);
        }
    }

    @Nonnull
    private Object evaluate(@Nonnull String script) throws IOException {
        Map<String, Object> param = new HashMap<>();
        param.put("returnByValue", Boolean.TRUE);
        param.put("expression", script);

        return send("Runtime.evaluate", param);
    }

    @Nonnull
    private Object send(@Nonnull String cmd, @Nonnull Map<String, Object> params) throws IOException {
        Map<String, Object> exe = ImmutableMap.of("cmd", cmd, "params", params);
        Command xc = new Command(m_wd.getSessionId(), "sendCommandWithResult", exe);
        Response response = m_wd.getCommandExecutor().execute(xc);

        Object value = response.getValue();
        if(response.getStatus() == null || response.getStatus().intValue() != 0) {
            //System.out.println("resp: " + response);
            throw new MyChromeDriverException("Command '" + cmd + "' failed: " + value);
        }
        if(null == value)
            throw new MyChromeDriverException("Null response value to command '" + cmd + "'");
        //System.out.println("resp: " + value);
        return value;
    }

    @Nullable
    static private <T> T jsonValue(@Nonnull Object map, @Nonnull String path, @Nonnull Class<T> type) {
        String[] segs = path.split("\\.");
        Object current = map;
        for(String name: segs) {
            Map<String, Object> cm = (Map<String, Object>) current;
            Object o = cm.get(name);
            if(null == o)
                return null;
            current = o;
        }
        return (T) current;
    }
}