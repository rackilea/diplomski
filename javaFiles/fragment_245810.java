loaded : function(guid, context, statuses) {
    CheckStatus.guid = guid;
    CheckStatus.context = context;
    // Here's the change
    CheckStatus.statuses = statuses;
    alert(CheckStatus.statuses[0]);