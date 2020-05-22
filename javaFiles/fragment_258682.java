@Component
public class UnseenSearchTermStrategy  implements SearchTermStrategy {
    UnseenSearchTermStrategy(){
        super();
    }
    @Override
    public SearchTerm generateSearchTerm(Flags flags, Folder folder) {
        return new FlagTerm(new Flags(Flags.Flag.SEEN), false);
    }
}