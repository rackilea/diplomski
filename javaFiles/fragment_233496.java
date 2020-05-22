holder.text = (TextView) convertView.findViewById(R.id.label);
        holder.text.setText(child.get(position).getName());


        return convertView;
  }