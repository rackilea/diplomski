@RequestMapping(value = AJAX_SEARCH_MED, method = RequestMethod.GET, headers="Content-Type=application/json")
        @ResponseBody
        public DataTablesAjaxResponse<ActiveMedicationView> ajaxSearchActiveMedication(
                @PathVariable(PATH_PIN) String pin,
                @RequestBody DataTablesAjaxRequest request)
{
// random code
};