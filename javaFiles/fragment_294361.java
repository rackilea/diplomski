@ModelAttribute("days")
public getDays(){
    DayInfo[][] days;
    //Here you have to instantiate the days to prepare it so it can be filled
    //You can load for example the data from the database
    return days;
}

@RequestMapping("/yourURL")
public String getFormData(@ModelAttribute("days")DayInfo[][] days){
    //Here in days you should have the data from the form overriding
    // the one from the database
}