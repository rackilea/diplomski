@Override
public View getView(final int position, View convertView, ViewGroup parent) {

    RelativeLayout view = (RelativeLayout) convertView;
    ViewHolder holder = null;

    if (view == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = (RelativeLayout) inflater.inflate(R.layout.exercise_set_item, parent, false);

        holder = new ViewHolder();
        holder.tvExerciseSetName = (TextView) view.findViewById(R.id.exerciseSetName);
        holder.tvExerciseSetDetails = (TextView) view.findViewById(R.id.exerciseSetDetails);
        holder.cbIsComplete = (CheckBox) view.findViewById(R.id.cbIsComplete);
        view.setTag(holder); 
    }else{
        holder = (ViewHolder) view.getTag();
    }

    if (exerciseSetList.get(position).getIsComplete() == 1) {
        holder.cbIsComplete.setChecked(true);
        isComplete = "1";
    }
    else {
        holder.cbIsComplete.setChecked(false);
        isComplete = "0";
    }

    holder.cbIsComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                exerciseSetList.get(position).setIsComplete(1);
                exerciseId = exerciseSetList.get(position).getExerciseId() + "";
                isComplete = "1";
            } else {
                exerciseSetList.get(position).setIsComplete(0);
                exerciseId = exerciseSetList.get(position).getExerciseId() + "";
                isComplete = "0";
            }
            new UpdateExerciseComplete().execute();
        }
    });

    holder.tvExerciseSetName.setText(exerciseSetList.get(position).getExerciseName());
    holder.tvExerciseSetDetails.setText(exerciseSetList.get(position).getExerciseDetails() + " id: " + exerciseSetList.get(position).getExerciseId());

    return view;
}