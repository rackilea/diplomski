if (row == null || (row.getTag()) == null){
        LayoutInflater inflater = LayoutInflater.from(activity);
        row = inflater.inflate(layoutRessource, null);
        holder = new ViewHolder();
        holder.mTitle = (TextView) row.findViewById(R.id.titre);
        holder.mDate = (TextView) row.findViewById(R.id.date);
        row.setTag(holder);
       }