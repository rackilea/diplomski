import java.util.List;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.preference.ListPreference;
import android.util.AttributeSet;

public class ApplicationSelector extends ListPreference
{
    private Context contexte;

    public ApplicationSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        contexte=context;
    }

    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        int index = findIndexOfValue(getSharedPreferences().getString(
                getKey(), "1"));

        AppliAdaptateur adapter = new AppliAdaptateur(contexte, this.getInstalledApplication(contexte), contexte.getPackageManager());

        builder.setAdapter(adapter, this);
        super.onPrepareDialogBuilder(builder);
    }


    public static List<ApplicationInfo> getInstalledApplication(Context c) {
        return c.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
    }


}