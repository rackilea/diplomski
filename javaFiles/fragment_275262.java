@RequestMapping("/commentProposal/{id}")
public String commentProposal(@PathVariable("id") Integer id, 
                              Model model) {
   model.addAttribute("p", proposalDao.findOne(id));
   return "commentProposal";
}

@Autowired
private ProposalDao proposalDao;