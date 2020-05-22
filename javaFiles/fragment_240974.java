<div id="vue-test">
  <div v-for="item in items" :key="item.id">    
    <p>Item id={{item.id}}, jobItemStatus = {{item.jobItemStatus}}</p>  
  </div>
</div>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script>    
var vueItems = new Vue({
    el: '#vue-test',
    data: {
        items : []
    },
    mounted: function(){
        <c:forEach items="${job.jobItems}" var="item" varStatus="status"> 
            this.items = this.items.concat({
                id: ${item.id}, 
                receptionDate : "${item.receptionDate}", 
                deliveryDate : "${item.deliveryDate}", 
                jobItemStatus : "${item.jobItemStatus}"
                });             
        </c:forEach>
    }
});
</script>