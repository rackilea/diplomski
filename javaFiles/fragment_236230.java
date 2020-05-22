package ro.rotry;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.io.IOException;

public class TestMr extends AppCompatActivity {

    MediaRecorder mr;
    MediaProjection mp;
    int dw = 720;
    int dh = 1280;
    MediaProjectionManager mpm;
    DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mr);
        mr = new MediaRecorder();
        initRecorder();
        mpm = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        startActivityForResult(mpm.createScreenCaptureIntent(), 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mp = mpm.getMediaProjection(resultCode, data);
        mp.createVirtualDisplay(getClass().getName(), dw, dh, metrics.densityDpi, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR, mr.getSurface(), new Callback(), null);
        mr.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        mr.stop();
    }

    class Callback extends VirtualDisplay.Callback {

    }

    private void initRecorder() {
        try {

            mr.setVideoSource(MediaRecorder.VideoSource.SURFACE);
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mr.setOutputFile(Environment
                    .getExternalStoragePublicDirectory(Environment
                            .DIRECTORY_DOWNLOADS) + "/video.mp4");
            mr.setVideoSize(dw, dh);
            mr.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
            mr.setVideoEncodingBitRate(12 * 1000 * 1000);
            mr.setVideoFrameRate(60);
            mr.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}