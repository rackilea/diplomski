package com.gujrat.quiz.qrcodereader;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.google.zxing.Result;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class ScannerFragment extends MasterFragment implements ZXingScannerView.ResultHandler {

    private static final String TAG = ScannerFragment.class.getSimpleName();
    private String mReadText;
    private ZXingScannerView mScannerView;

    public ScannerFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mScannerView = new ZXingScannerView(getActivity());   // Programmatically initialize the scanner view
        return mScannerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

        mReadText = rawResult.getText();
        Log.v(TAG, "qrcode rawresult: " + rawResult.getText()); // Prints scan results
        Log.v(TAG, "qrcode format: " + rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)



    }

    private void showSuccessDialog() {
        SweetAlertDialog dialog = new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Done!")
                .setContentText("Thank you for using service")
                .setCancelText("Exit!")
                .setConfirmText("Use again!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismiss();
                        getActivity().finish();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        resumeScanView();
                    }
                });
        dialog.setCancelable(false);
        dialog.show();

    }

    private void resumeScanView() {
        mReadText = "";
        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(ScannerFragment.this);
            }
        }, 2000);
    }

    private void startBeepSound() {
        ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
        toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }




}