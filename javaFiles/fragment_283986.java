<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#bbb"
    tools:context="${packageName}.${activityClass}" >

    <ImageButton
        android:id="@+id/imButton1"
        android:layout_toLeftOf="@+id/imButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginRight="0dp"
        android:layout_alignTop="@+id/imButton2"
        android:background="@drawable/icon1_unselected" />

    <ImageButton
        android:id="@id/imButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="23dp"
        android:layout_alignParentTop="true"
        android:background="@drawable/icon2_selected" />

    <ImageButton
        android:id="@+id/imButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@id/imButton2"
        android:layout_toRightOf="@id/imButton2"
        android:background="@drawable/icon3_unselected" />

</RelativeLayout>