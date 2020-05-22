if (convertView == null) {
            // LayoutInflater vi = (LayoutInflater)
            // getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.claim_list, null);

            holder = new ViewHolder();

            holder.claim_list_layout = (LinearLayout) convertView
                    .findViewById(R.id.claim_list_layout);
            holder.claimnumb = (TextView) convertView
                    .findViewById(R.id.claimnumb);
            holder.insuerdname = (TextView) convertView
                    .findViewById(R.id.insuerdname);

            holder.claimaddress = (TextView) convertView
                    .findViewById(R.id.claimaddress);
            holder.btn_start = (Button) convertView
                    .findViewById(R.id.btn_start);

            convertView.setTag(holder);

        }
        else
         {
             holder = (ViewHolder) convertView.getTag();
          }

        final Claim_list claim_option = claim_list_adaptor.get(position);

        holder1.claimnumb.setText(claim_option.getClaimNumber());
        holder1.insuerdname.setText(claim_option.getInsuredName());
        holder1.claimaddress.setText(claim_option.getPropertyAddress());



        holder1.btn_start.setVisibility(View.GONE);
        if (position == 0 && isoncreate) {
            isoncreate = false;
            holder1.claim_list_layout
                    .setBackgroundResource(R.drawable.claim_list_active);
            holder1.btn_start.setVisibility(View.VISIBLE);
            beanclass.setClaim_info_header("Claim: "
                    + claim_option.getClaimNumber() + " / "
                    + claim_option.getInsuredName());
            TV_claiminfo.setText(beanclass.getClaim_info_header());
        } else {
            holder1.claim_list_layout
                    .setBackgroundResource(R.drawable.claim_list_inactive);
        }

        return convertView;
    }