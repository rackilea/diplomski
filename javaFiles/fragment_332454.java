<form role="form" action="/SendEmail" method="get" enctype="text/plain">
<div class="form-group">
    <label for="emailinput"><h4><span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;E-mail</h4></label>
    <input class="form-control" type="email" id="emailinput" placeholder="Entrez votre e-mail">
    </input>
</div>
<div class="form-group">
    <label for="messageinput"><h4><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;Message</h4></label>
    <textarea class="form-control" id="messageinput" placeholder="Ecrivez votre message" rows="3"></textarea>
</div>
<br/>
<div class="text-right">
    <button type="submit" class="btn btn-default">
        <span class="glyphicon glyphicon-upload"></span>&nbsp;&nbsp;Envoyer
    </button>
</div>
</form>