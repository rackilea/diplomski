public void onBindViewHolder(final ViewHolder holder, final int position)
{
    final SomeClass data = my_data.get(position);

    holder.seekBar.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
        @Override
        public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser)
        {
            holder.seekBar.setProgress(holder.seekBar.getProgress());
            holder.actual_estimate.setText(holder.seekBar.getProgress()+"/" + data.getEstimate());
        }