import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("url")
    @Expose
    private List<String> url = null;
    @SerializedName("apply")
    @Expose
    private Apply apply;
    @SerializedName("controls")
    @Expose
    private Controls controls;
    @SerializedName("remove")
    @Expose
    private Remove remove;

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public Controls getControls() {
        return controls;
    }

    public void setControls(Controls controls) {
        this.controls = controls;
    }

    public Remove getRemove() {
        return remove;
    }

    public void setRemove(Remove remove) {
        this.remove = remove;
    }


    public class Controls {

        @SerializedName("promo")
        @Expose
        private String promo;
        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("orderTotal")
        @Expose
        private String orderTotal;
        @SerializedName("coupon")
        @Expose
        private String coupon;

        public String getPromo() {
            return promo;
        }

        public void setPromo(String promo) {
            this.promo = promo;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getOrderTotal() {
            return orderTotal;
        }

        public void setOrderTotal(String orderTotal) {
            this.orderTotal = orderTotal;
        }

        public String getCoupon() {
            return coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }

    }

    public class Remove {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("submit")
        @Expose
        private String submit;
        @SerializedName("timeout")
        @Expose
        private Integer timeout;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSubmit() {
            return submit;
        }

        public void setSubmit(String submit) {
            this.submit = submit;
        }

        public Integer getTimeout() {
            return timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

    }

    public class Apply {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("submit")
        @Expose
        private String submit;
        @SerializedName("timeout")
        @Expose
        private Integer timeout;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSubmit() {
            return submit;
        }

        public void setSubmit(String submit) {
            this.submit = submit;
        }

        public Integer getTimeout() {
            return timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

    }

}