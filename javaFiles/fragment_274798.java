//name of input html should be collage
@PostMapping("/sending")
public String redirect(@RequestParam("collage") MultipartFile[] files, RedirectAttributes redirectAttr) {

        Collections.shuffle(Arrays.asList(files));
        redirectAttr.addFlashAttribute("pictures",files);
        return "redirect:/collage"; 
}