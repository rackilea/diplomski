<div>
    <form th:action="@{/saveOrderAndReload(name=${pizza.name}, amount=${amount}, size=${pizzaSize})}" method="post">
        <div class="input-group">
            <span class="input-group-addon">Bestellmenge:</span>
            <input type="number" name="amount" class="form-control" placeholder="1"/>
        </div>
        <div class="input-group>
            <input type="radio" name="pizzaSize" value="1"> Klein</input>
            <input type="radio" name="pizzaSize" value="2"> Mittel</input>
            <input type="radio" name="pizzaSize" value="3"> Gross</input>
        </div>
        <div class="form-group">
            <div class="form-group">
                <input type="submit" class="btn btn-primary btn-success" value="zur Bestellung hinzufuegen"/>
            </div>
        </div>
    </form>
</div>