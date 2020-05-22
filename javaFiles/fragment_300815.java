package com.microsoft.onedriveaccess.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ItemList {
    @SerializedName("value")
    public List<Item> itemList;
}