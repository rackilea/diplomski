<div th:each="item, phoneStat : *{phones}">
    <select th:field="*{phones[__${phoneStat.index}__].variety}">
        <option></option>
    </select>
    <div class=" input-field col s4">
        <input class="validate" th:field="*{phones[__${phoneStat.index}__].number}"
               th:id="${'phonenumber-'+ phones[__${phoneStat.index}__]}" type="text"/>
        <label th:for="${'phonenumber-'+ phones[__${phoneStat.index}__]}"> Mobile</label>
    </div>
</div>