holder.getView().setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
    switch (mainItem.getNameMain().toLowerCase()) {
        case "admin":
            context.startActivity(new Intent(context, AdminActivity.class));
            break;
        case "customer":
            context.startActivity(new Intent(context, CustomerActivity.class));
            break;
        case "packages":
            context.startActivity(new Intent(context, PackagesSelectorActivity.class));
            break;
        case "live chat":
            context.startActivity(new Intent(context, LiveChatActivity.class));
            break;
        case "profit report":
            context.startActivity(new Intent(context, ProfitReportActivity.class));
            break;
        case "transaction":
            context.startActivity(new Intent(context, TransactionActivity.class));
            break;
    }

}
});