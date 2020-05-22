public override int GetItemViewType(int position)
    {
        if (items[position].Type == 0)
            return LAYOUT_ONE;
        else
            return LAYOUT_TWO;
    }