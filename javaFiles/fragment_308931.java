public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = null;
        switch (viewType)
        {
            case LAYOUT_ONE:
                view = LayoutInflater.From(parent.Context).Inflate(Resource.Layout.customview_user_writepostbar, parent, false);
                return new CreatePostViewHolder(view);

            case LAYOUT_TWO:
                view = LayoutInflater.From(parent.Context).Inflate(Resource.Layout.customview_postregular, parent, false);
                return new PostRegularViewHolder(view);

        }
    }