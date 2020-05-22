package com.syncedsoftware.player; // changed package name

import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayer;

public class UnityPlayerActivity extends com.unity3d.player.UnityPlayerActivity // extends the ORIGINAL implementation
{

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

   // Process intent data
}

// Setup activity layout
@Override protected void onCreate (Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
}
}