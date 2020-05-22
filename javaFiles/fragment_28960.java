List<? extends Member> members =  membersMgr.getMembers();
for (Member member: members) {
     if (member instanceof MemberNio) {
          MemberNio memNio = (MemberNio)member;
          /** Do your stuff **/
     }
}