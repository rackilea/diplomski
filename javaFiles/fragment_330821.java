public int thisWasClicked(CustomCowAdapter.CowViewHolder cowViewHolder) {

    int position = cowViewHolder.getAdapterPosition();

    switch (position) {
        case 0:
            return setColorToDrawable(position, clicks1++);

        case 1:
            return setColorToDrawable(position, clicks2++);

        case 2:
            return setColorToDrawable(position, clicks3++);

        case 3:
            return setColorToDrawable(position, clicks4++);

        case 4:
            return setColorToDrawable(position, clicks5++);

        case 5:
            return setColorToDrawable(position, clicks6++);

        default:
            return setColorToDrawable(position, clicks7++);

    }


}


public int setColorToDrawable(int i, int clicks) {
    if (clicks < 4) return colorsArray[i][clicks];
    else return -1;
}