public override void 
        OnBindViewHolder (RecyclerView.ViewHolder holder, int position)
    {
        int type = GetItemViewType(position);

        switch (type)
        {
            case LAYOUT_ONE:
                CreatePostViewHolder vh2 = holder as CreatePostViewHolder;
                vh2.userFirstName.Text = UserFirstName + ", share something inspiring!";
                break;
            case LAYOUT_TWO:
                PostRegularViewHolder vh = holder as PostRegularViewHolder;
                // other code
                break;
            default:
                break;
        }
    }