package com.example;

import android.net.Uri;

public class Avatar {
    AvatarType _avatarType;
    Uri _uri;

    public Avatar(AvatarType type, Uri uri) {
        _avatarType = type;
        _uri = uri;
    }

    public AvatarType getType() {
        return _avatarType;
    }

    public Uri getUri() {
        return _uri;
    }
}