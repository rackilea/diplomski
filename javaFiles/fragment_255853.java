public void setInstituteInfoDetails(List<InstituteInfoDetails> instituteInfoDetails)
{
    for(InstituteInfoDetails ins : instituteInfoDetails){
        ins.setComListMaster(this);
    }
    this.instituteInfoDetails = instituteInfoDetails;
}