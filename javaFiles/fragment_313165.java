public static void update(JsonObject body) {
    try {
        Long id = (long) body.get("id").getAsInt();
        CaseFolder cf  = CaseFolder.loadAndVerifyOwner(getConnectedUser(), id);
        cf.number = body.get("number").getAsString();
        cf.description = body.get("description").getAsString();
        if(cf.validateAndSave())
            ok();
        else
            error();
    }
    catch (NullIdException      e) {error();} 
    catch (NotFoundException    e) {notFound();} 
    catch (NotOwnerException    e) {forbidden();}
    catch (Exception            e) {e.printStackTrace(); error();}
}