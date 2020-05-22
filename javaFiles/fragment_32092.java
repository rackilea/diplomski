/**
 * @param strutsActionExtension the strutsActionExtension to set
 */
@Inject(StrutsConstants.STRUTS_ACTION_EXTENSION) //Note this isn't necessarily supported
public void setStrutsActionExtension(String strutsActionExtension) {
    this.strutsActionExtension = strutsActionExtension;
}