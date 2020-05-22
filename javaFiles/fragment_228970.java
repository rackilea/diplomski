package com.example;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

public class ViewModel extends BaseObservable {
    @Bindable
    public int getDummyVisibility() {
        // TODO: This is a work around. Currently data binding crashes on certain views if they don't have binding.
        return View.VISIBLE;
    }
}