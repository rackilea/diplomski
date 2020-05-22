package org.sonar.template.java.checks;

import com.google.common.collect.ImmutableList;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Symbol.TypeSymbol;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.*;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import java.util.List;

@Rule(
    key = "SharedPreferencesRule",
    name = "Utilização de SharedPreferences no código",
    description = "Para cada utilização de SharedPreferences, é feito um alerta para revisar o que está sendo armazenado.",
    priority = Priority.CRITICAL,
    tags = {"attention point", "security"})
public class SharedPreferencesCheck extends IssuableSubscriptionVisitor {

    @Override
  public List<Kind> nodesToVisit() {
    return ImmutableList.of(Kind.METHOD_INVOCATION);
  }

  @Override
  public void visitNode(Tree tree){
      System.out.println("====================== Kind Finded ======================");

      MethodInvocationTree kindTree = (MethodInvocationTree) tree;

      Symbol symbol = (Symbol) kindTree.symbol();

      TypeSymbol classe = symbol.owner().enclosingClass();

      System.out.println("Name >>>>>>>>>>>>> " + symbol.name());
      System.out.println("Enclosing >>>>>>>>>>>>> " + classe);

      if (classe != null && classe.equals("SharedPreferences")){
          reportIssue(kindTree.firstToken(), "SharedPreferences sendo utilizado no código. Analisar!!");
      }

  }
}