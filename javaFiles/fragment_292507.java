int getItemViewTypeSwitch(int position) {
    if (isActive()){
        /**
         * works on classes
         * @see android.support.v7.widget.CardView
         * {@link android.support.v7.widget.CardView}
         * 
         * on methods
         * {@link me2.iwanttoeat.FR_RecycleViewSettings#getLayout()}
         * @see me2.iwanttoeat.FR_RecycleViewSettings#getLayout()
         * 
         * on subclasses
         * @see FR_Adapter.ViewHolder
         * {@link FR_Adapter.ViewHolder}
         */
        return position;
    }
    return -1;
}