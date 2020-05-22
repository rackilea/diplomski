"items":[{

            "xtype":"textfield",
            "fieldLabel":CQ.I18n.getMessage("Mail"),
            "anchor":"100%",
            "vtype":"email",
            "msgTarget":"under",
            "name":"email"
        },{
            "xtype":"textfield",
            "fieldLabel":CQ.I18n.getMessage("My Field"),
            "anchor":"100%",
            "msgTarget":"under",
            "name":"myfield"
        },{
            "xtype":"textarea",
            "fieldLabel":CQ.I18n.getMessage("About"),
            "anchor":"100% -155",
            "name":"aboutMe"


    }],


loadRecord: function(rec) {
this.enableUserSaveButton(false);
this.enableGroupSaveButton(false);

var type = rec.get("type");
if (type=="user") {
    this.activeForm = this.userForm;
    this.hiddenForm = this.groupForm;
    if (rec.id==CQ.security.UserProperties.ADMIN_ID) {
        this.pwdButtons.each(function(bt) {bt.hide(); return true;} )
    } else {

        this.pwdButtons.each(function(bt) {bt.show(); return true;} )
    }

} else {
    this.activeForm = this.groupForm;
    this.hiddenForm = this.userForm;
}
//is loading additional property from json and show it in formular
rec.data["myfield"] = rec.json["myfield"];

this.activeForm.getForm().loadRecord(rec);