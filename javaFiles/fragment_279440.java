@Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final AnimalsArray object = mList.get(position);

        /* middle holders contributing to the total volume of the same have the
         *same groupId together with their corressponding bottom holder.
         *TODO: Assigned this value in accordance to however you are assigning Middle ViewHolders to Bottom ViewHolders*/
        int groupId = 0;

        if (object != null) {
            switch (object.getCategory()) {

                case AnimalsArray.TOP:
                    break;


                case AnimalsArray.MIDDLE:

                    Middle middleHolder = (Middle) holder;


                    middleHolder.weight.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                        }

                        @Override
                        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                                      int arg3) {

                        }

                        @Override
                        public void afterTextChanged(Editable arg0) {

                            //While this edittext is being changed, I would like the 3rd viewtype which contains the volume to be calculated on the fly as the user enters numbers in this field.


                            String volumeBeforeChange = middleHolder.volume.getText().toString();
                            double previousVolume = Double.parseDouble(volumeBeforeChange);

                            if (arg0.toString().isEmpty() || arg0.toString().length() <= 0 || arg0.toString().equals("") || arg0.toString() == null || arg0.toString().equals("0") || arg0.toString().startsWith(".")) {
                                middleHolder.weight.setText("0");
                                middleHolder.animalVolumeChangeListener.onAnimalVolumeChanged(middleHolder.groupId,previousVolume,0);
                            } else {
                                volume = calculateWarmUpVolume(context, arg0.toString(), ((Middle) holder).quantity.getText().toString());
                                middleHolder.animalVolumeChangeListener.onAnimalVolumeChanged(middleHolder.groupId,previousVolume,volume);

                            }
                        }
                    });


                    middleHolder.quantity.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                        }

                        @Override
                        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                                      int arg3) {
                        }

                        @Override
                        public void afterTextChanged(Editable arg0) {

                            //While this edittext is being changed, I would like the 3rd viewtype which contains the volume to be calculated on the fly as the user enters numbers in this field.

                            String volumeBeforeChange = middleHolder.volume.getText().toString();
                            double previousVolume = Double.parseDouble(volumeBeforeChange);

                            if (arg0.toString().isEmpty() || arg0.toString().length() <= 0 || arg0.toString().equals("") || arg0.toString() == null || arg0.toString().equals("0") || arg0.toString().startsWith(".")) {
                                ((Middle) holder).quantity.setText("0");
                                middleHolder.animalVolumeChangeListener.onAnimalVolumeChanged(middleHolder.groupId,previousVolume,0);
                            } else {
                                volume = calculateWarmUpVolume(context, ((Middle) holder).weight.getText().toString(), arg0.toString());
                                middleHolder.animalVolumeChangeListener.onAnimalVolumeChanged(middleHolder.groupId,previousVolume,volume);

                            }
                        }
                    });

                    break;


                case AnimalsArray.BOTTOM:

                    Bottom bottomHolder = ((Bottom) holder);


                    Pair<LifecycleOwner, LiveData<Double>> totalVolumePair = bottomHolder.totalVolumeInterface.getTotalVolume(groupId);
                    totalVolumePair.second.observe(totalVolumePair.first,
                            new Observer<Double>(){
                                @Override
                                public void onChanged(Double aDouble) {
                                    //Check if double is a whole number. If it is, remove decimal by converting to integer
                                    String volumedWeight;
                                    if ((aDouble % 1) == 0) {
                                        int roundedVolume = aDouble.intValue();
                                        volumedWeight = Integer.toString(roundedVolume);
                                    } else {
                                        volumedWeight = Double.toString(volume);
                                    }

                                    bottomHolder.volume.setText(String.valueOf(volumedWeight));
                                }
                            }
                    );


                    break;
            }

        }
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
        /* middle holders contributing to the total volume of the same have the
         *same groupId together with their corressponding bottom holder.
         */
        int groupId = 0;
        if(holder instanceof Bottom){
            ((Bottom) holder).totalVolumeInterface.removeObservers(groupId);
        }
    }