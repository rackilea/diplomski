@RequestMapping(value = "/login", method = ResquestMethod.POST)
public String handleLogin([...]) {
    ...
    if (successful) {
        return "redirect:/welcome"
    }
}