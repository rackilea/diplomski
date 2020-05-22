@RequestMapping(value="/deleteTeam", method=RequestMethod.GET)
        @ResponseBody
        public String getByIdFromParam(@RequestParam Long teamID) {
         try{
                teamService.delete(new Teams().setTeamID(teamID));
            }catch (DataIntegrityViolationException ex){
                return "error";
            }
            return "sucess";
        }