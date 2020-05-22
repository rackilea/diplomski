package com.example.frisbeecaddy;

public class NewGamePlayerItem {
    private boolean mCheckBox;
    private String mText;
    private boolean mIsSelected;

    public NewGamePlayerItem(boolean checkBox, String text, boolean isSelected) {
        mCheckBox = checkBox;
        mText = text;
        mIsSelected = isSelected;
    }

    public boolean getCheckBox() {
        return mCheckBox;
    }

    public String getmText() {
        return mText;
    }


    // the added methods here
    public boolean isSelected() {
       return mIsSelected;
    }

    public void setSelected(boolean isSelected) {
        mIsSelected = isSelected;
    }
}