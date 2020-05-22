public class MyAdapter extends RecyclerView.Adapter<MyFragment.ViewHolder> {

    public static final int ITEM_TYPE = 100;
    public static final int HEADER_TYPE = 101;
    public static final int HEADER_TYPE_2 = 102;
    public static final int INTRO_TYPE = 103;

    private ArrayList<CharSequence> dataTitle;
    private ArrayList<String> dataSubtitle;
    private ArrayList<String> dataDescription;

    private Boolean expandedAll;
    private Boolean collapsedAll;

    public MyAdapter(ArrayList<CharSequence> dataTitle, ArrayList<String> dataSubtitle, ArrayList<String> dataDescription) {
        this.dataTitle = dataTitle;
        this.dataSubtitle = dataSubtitle;
        this.dataDescription = dataDescription;
    }

    @NonNull
    @Override
    public MyFragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        switch (type) {
            case HEADER_TYPE:
                return new MyFragment.ViewHolder(inflateHelper(parent.getContext(), R.layout.recyclerview_header, parent));

            case HEADER_TYPE_2:
                return new MyFragment.ViewHolder(inflateHelper(parent.getContext(), R.layout.recyclerview_header, parent));

            case ITEM_TYPE:
                return new MyFragment.ViewHolder(inflateHelper(parent.getContext(), R.layout.recyclerview_item_tv_itemtype, parent));

            case INTRO_TYPE:
                return new MyFragment.ViewHolder(inflateHelper(parent.getContext(), R.layout.recyclerview_item_tv_intro, parent));

            default:
                return new TabFragmentWATTerminus.ViewHolder(inflateHelper(parent.getContext(), R.layout.recyclerview_item_tv_itemtype, parent));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyFragment.ViewHolder viewHolder, int position) {
        final Typeface iconFont = FontManager.getTypeface(getContext(), FontManager.FONTAWESOME);
        final RelativeLayout rlInformation = viewHolder.itemView.findViewById(R.id.rl_information);

        switch (getItemViewType(position)) {
            case HEADER_TYPE:
                Button expandButton = viewHolder.itemView.findViewById(R.id.button);
                expandButton.setText(R.string.expand_all);

                expandButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expandedAll = true;
                        collapsedAll = false;
                        notifyDataSetChanged();
                    }
                });

                break;
            case HEADER_TYPE_2:
                Button collapseButton = viewHolder.itemView.findViewById(R.id.button);
                collapseButton.setText(R.string.collapse_all);

                collapseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        expandedAll = false;
                        collapsedAll = true;
                        notifyDataSetChanged();
                    }
                });
                break;
            case INTRO_TYPE:
                TextView tvIntroA = viewHolder.itemView.findViewById(R.id.tv_placeholder;
                tvIntroA.setVisibility(View.GONE);
                break;
            case ITEM_TYPE:
                // get the current item
                CharSequence itemA = dataTitle.get(position - 3);
                String itemB = dataSubtitle.get(position - 3);
                String itemC = dataDescription.get(position - 3);

                //
                final TextView txtTitle = viewHolder.itemView.findViewById(R.id.tv_title);
                txtTitle.setText(itemA);

                final TextView txtSubtitle = viewHolder.itemView.findViewById(R.id.tv_subtitle);
                txtSubtitle.setText(itemB);

                final TextView txtDescription = viewHolder.itemView.findViewById(R.id.tv_description);
                txtDescription.setText(itemC);

                final TextView txtArrowTV = viewHolder.itemView.findViewById(R.id.tv_expandcollapsearrow);
                txtArrowTV.setText(R.string.fa_icon_chevron_down);
                txtArrowTV.setTypeface(iconFont);

//                        final RelativeLayout rlInformation = viewHolder.itemView.findViewById(R.id.rl_information);
                rlInformation.setVisibility(View.GONE);

                //
                CardView cardView = viewHolder.itemView.findViewById(R.id.cardview_item);
                LinearLayout mLinearLayoutTV = viewHolder.itemView.findViewById(R.id.cardview_titlerow);

                //
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (rlInformation.getVisibility() == View.GONE) {
                            expandRL(rlInformation, txtArrowTV);
                        } else {
                            collapseRL(rlInformation, txtArrowTV);
                        }
                    }
                });

                mLinearLayoutTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (rlInformation.getVisibility() == View.GONE) {
                            expandRL(rlInformation, txtArrowTV);
                        } else {
                            collapseRL(rlInformation, txtArrowTV);
                        }
                    }
                });

                txtArrowTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (rlInformation.getVisibility() == View.GONE) {
                            expandRL(rlInformation, txtArrowTV);
                        } else {
                            collapseRL(rlInformation, txtArrowTV);
                        }
                    }
                });

                if (expandedAll) {
                    expandRL(rlInformation, txtArrowTV);
                } else if (collapsedAll) {
                    collapseRL(rlInformation, txtArrowTV);
                }

                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataTitle.size() + 3;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return HEADER_TYPE;
            case 1:
                return HEADER_TYPE_2;
            case 2:
                return INTRO_TYPE;
            default:
                return ITEM_TYPE;
        }
    }

    private View inflateHelper(Context context, int resId, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(resId, parent, false);
    }

}