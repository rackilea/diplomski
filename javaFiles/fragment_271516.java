@PostMapping(INGEST_URL)
    public String ingestDataFile(@RequestParam("file") MultipartFile file,
RedirectAttributes redirectAttributes) {
     if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "No File is Present");
                return "redirect:uploadStatus";
            }
             try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get("FOLDER TO UPLOAD TO" + file.getOriginalFilename());
                Files.write(path, bytes);

                redirectAttributes.addFlashAttribute("message",
                        "File upload successful'" + file.getOriginalFilename() + "'");

            } catch (IOException e) {
                e.printStackTrace();
            }

            return "redirect:/uploadStatus";
    }
    @GetMapping("/uploadStatus")
        public String uploadStatus() {
            return "uploadStatus";
        }