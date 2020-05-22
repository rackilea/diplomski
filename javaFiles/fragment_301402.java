<Button
            android:id="@+id/add_key_button"
            android:layout_width="match_parent"
            android:visibility="@{businessLogic.toggleOn ? View.VISIBLE : View.GONE}"
            android:layout_height="wrap_content"
            android:text="Add key" />