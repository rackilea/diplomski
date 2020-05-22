<form th:action="@{/newjob}" th:object="${addNewJob}" method="post">
        <div class="form-group">
            <label for="">Offer Title</label> 
            <input type="text" th:field="*{jobtitle}"  class="form-control" placeholder="Entre Offer Title" />
                 <small class="form-text text-muted">We'll never share your email
                with anyone else.</small>
        </div>

        <div class="form-group">
            <label >Company Name</label>
             <input type="text" th:field="*{jobcompany}"  class="form-control" placeholder="Enter Company Name"/>
        </div>


        <div class="form-group dropdown">
            <label for="sel1">Choose Category (select one):</label> 
            <select name="*selectCategory"
                class="form-control" id="selectCategory"
                onchange="getSelectedValue();"
                th:field="*{selectCategory}">

                <option value="">Select Option</option>
                <option value="software_engineer">Software Engineer</option>
                <option value="graphic_design ">Graphic Design</option>
                <option value="customer_service ">Customer Service</option>
                <option value="marketing" >Marketing</option>
                <option value="healthcare">Health Care</option>

            </select>
        </div>

        <div class="form-group">
            <label for="exampleInputPassword1">Offer</label>
            <textarea class="form-control" th:field="*{jobtext}" placeholder="Describe your job offer"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit Offer</button>
    </form>