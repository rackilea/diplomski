CompoundPropertyModel<MetaCommentTechSpeedBean> props = 
    new CompoundPropertyModel<MetaCommentTechSpeedBean>(metaCommentTechSpeedBean);
Form<MetaCommentTechSpeedBean> form = new Form<MetaCommentTechSpeedBean>("wicketid", props);
CheckBox dsChk = new CheckBox("dsChk");
form.add(dsChk);
add(form);