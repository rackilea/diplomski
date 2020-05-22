public Plan createFromParcel(Parcel in) {
        Plan plan = new Plan();
        plan.setId(in.readString());
        plan.setName(in.readString());
        return plan;
}