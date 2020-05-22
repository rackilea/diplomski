@JsonIgnoreType
public class IgnoreType {}

interface IgnoreMethods {
    @JsonIgnore
    void setContent(int resId);

    @JsonIgnore
    void setContent(View view);

    @JsonIgnore
    void setContent(View view, ViewGroup.LayoutParams lp);

    @JsonIgnore
    void setContent(CharSequence text);
}