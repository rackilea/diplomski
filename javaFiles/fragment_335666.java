@RequestMapping({"/someurl"})
public String execute(Model model) {
    if (someCondition) {
        return "forward:/someUrlA";
    } else {
        return "forward:/someUrlB";
    }
}