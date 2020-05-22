@RequestMapping("/members")
public String getMembers(Model model) {
    List<Member> members = memberDao.getMembers();
    model.addAttribute("members", members);
    return "member/membersList";
}