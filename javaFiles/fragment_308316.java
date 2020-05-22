@GetMapping(value = "/piecases/download")
public String downloadExcel(Model model,
        @RequestParam(name = "dateBefore") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dateBefore,
        @RequestParam(name = "dateAfter") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dateAfter) {
    model.addAttribute("cases", outboundBankErrorService.exportAllCasesByDate(dateBefore, dateAfter));
    return "";
}