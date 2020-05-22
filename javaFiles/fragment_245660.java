private StdTerm retrieveStdTerm(BigInteger stdTermId, boolean isGlobal, String errorTerm)
{
    StdTerm stdTerm = getTerm(BigInteger stdTermId);
    if (stdTerm == null || !getBuilder().getOwnerId().equals(stdTerm.getOwnerId()))
    {
        throw new ServiceException(GLOBAL_TERM_TO_DELETE_DOES_NOT_EXIST_MSG,
                CANNOT_DELETE_GLOBAL_TERM, GLOBAL_TERM_DOES_NOT_EXIST);
    }
    if (stdTerm.isGlobal() && !isGlobal)
    {
        throw new ServiceException(
                "Global Term can not be updated: incorrect URL.",
                errorTerm, INCORRECT_URL);
    }
    if (stdTerm.isLocked() != null && stdTerm.isLocked())
    {
        throw new ServiceException("Global Term can not be updated: stdTerm is locked.",
                errorTerm, TERM_LOCKED);
    }
    return stdTerm;
}

private ModResponse updateNDelTerms(GlobalTermDeleteType item, boolean isGlobal)
{
    StdTerm stdTerm = retrieveStdTerm(item.getstdTermId(), isGlobal,
            CANNOT_DELETE_GLOBAL_TERM);
    return updateNDel(item, stdTerm);
}

public ItemResponse<List<stdTermItemType>> copyTerm(BigInteger stdTermId, boolean isGlobal,
        boolean isFalse)
{
    StdTerm stdTerm = retrieveStdTerm(stdTermId, isGlobal, CANNOT_COPY_GLOBAL_TERM);
    return copyGlobleTerm(stdTerm, pasteTermObj, isFalse);
}