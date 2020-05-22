public static void main(String[] args) throws Exception {
    String[] urls = {
            "http://www.buy.com/prod/disney-s-star-struck/q/loc/109/213724402.html", 
            "http://www.buy.com/prod/samsung-f2380-23-widescreen-1080p-lcd-monitor-150-000-1-dc-8ms-1920-x/q/loc/101/211249863.html",
            "http://www.buy.com/prod/panasonic-nnh765wf-microwave-oven-countertop-1-6-ft-1250w-panasonic/q/loc/66357/202045865.html",
            "http://www.buy.com/prod/escape-by-calvin-klein-for-women-3-4-oz-edp-spray/q/loc/66740/211210860.html",
            "http://www.buy.com/prod/v-touch-8gb-mp3-mp4-2-8-touch-screen-2mp-camera-expandable-minisd-w/q/loc/111/211402014.html"
    };

    String all = "[^/]+";
    String[] pattern = urls[0].split("/");
    for (int i = 0; i < urls.length; i++) {
        String parts[] = urls[i].split("/");

        // TODO handle urls with different number of parts
        for (int j = 0; j < pattern.length; j++) {
            // intentionally match by reference
            if (pattern[j] != all && !pattern[j].equals(parts[j])) {
                pattern[j] = all;
            }
        }
    }

    // build pattern - use [^/]+ as a replacement (anything but a '/')
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < pattern.length; i++) {
        buf.append(pattern[i] == all ? all : Pattern.quote(pattern[i]));
        buf.append("/");
    }
    // stip last "/"
    buf.setLength(buf.length() - 1);

    // compile pattern
    Pattern p = Pattern.compile(buf.toString());

    // output
    System.out.println(p.pattern());
    for (int i = 0; i < urls.length; i++) {
        System.out.println(p.matcher(urls[i]).matches());
    }

}