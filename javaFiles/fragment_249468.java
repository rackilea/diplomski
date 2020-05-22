public class USAGOV {

    private VotingBody senate = new VotingBody(105);
    private VotingBody congress = new VotingBody(305);
    private VotingBody president = new VotingBody(1);

    void passLaw() {
        //logic to count votes from senate, congress and president
    }

    private class VotingBody {
        int members;
        int law;

        VotingBody(int members){
            this.members = members;
        }

        int getSize() {
            return members;
        }

        void voteYes() {
            int yes = 1;
            law = law + yes;
        }

        void voteNo() {
            int no = -1;
            law = law + no;
        }

        void addMembers(int members){
            this.members += members;
        }

        void removeMembers(int members){
            this.members -= members;
        }

    }
}