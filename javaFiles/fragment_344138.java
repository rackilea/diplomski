@PostMapping(value = "/modify-store")
@ResponseBody
public boolean deleteEntry(@ModelAttribute Store store) throws Exception {
    // Your code here...
    return true;
}