package com.syncedsoftware.cameralink;

import android.content.Intent;
import android.provider.MediaStore;

import com.unity3d.player.UnityPlayer;

/**
 * Created by Anthony on 5/30/2015.
 */
public class LinkBridge {

public static void ShowCamera(int requestCode){
    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    UnityPlayer.currentActivity.startActivityForResult(cameraIntent, requestCode); // Gets custom activity and uses the callback accordingly
}

}